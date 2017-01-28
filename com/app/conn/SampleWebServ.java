package com.app.conn;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Customer;
import com.app.model.Item;
import com.app.service.ICustomerService;
import com.app.service.IItemService;
import com.app.validator.CustomerValidator;

@Component
@Path("/sample")
@Consumes("application/json")
public class SampleWebServ {

	@Autowired
	private CustomerValidator custValidator;
	@Autowired
	private ICustomerService custService;
	@Autowired
	private IItemService itemService;

	@Path("/save")
	@POST
	@Consumes("application/json")
	public String testMethod(
			@HeaderParam("uname")String name,
			@HeaderParam("password")String pwd,
			@HeaderParam("token")String accTok,
			Item item
			){
		String resMsg=null;

		//find user in db
		Customer cust=custService.getCustByEmail(name);
		if(cust!=null){
			boolean flag=custValidator.isValidSeller(cust, pwd, accTok);
			if(flag){
				if(item!=null){
					item.setCustId(cust.getCustId());
					int id=itemService.saveItem(item);
					resMsg="Item saved with id:: "+id;
				}else{
					resMsg="Item is Invalid";
				}
			}else{
				resMsg="Invalid seller-please send a valid Password and Token";
			}
		}else{
			resMsg="Invalid Customer";
		}

		return resMsg;
		//		if(custValidator.isUserExist(name)){
		//			return "valid user"+customer;
		//		}
		//		else{
		//			return "invalid user";
		//		}
		//		return "Hello...Welcome to ReST Web Services:: "+name+","+pwd+","+accTok;
	}
}