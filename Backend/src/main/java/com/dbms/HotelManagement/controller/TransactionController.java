package com.dbms.HotelManagement.controller;

import com.dbms.HotelManagement.model.Transaction;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TransactionController {
    @PostMapping("/transaction")
    public String transactionHandler(@RequestBody Transaction transaction) throws RazorpayException {
        int amount = transaction.getAmount();
//        System.out.println(amt);
//        String amount = transaction.getAmount();

        RazorpayClient client = new RazorpayClient("rzp_test_7dHk9zNMuGYDSV", "Yi9VbqSWRd2ATqA6W7dInDYR");
//
        JSONObject option = new JSONObject();
        option.put("amount", amount*100);
        option.put("currency", "INR");
        option.put("receipt", "txn_123456");
//
//        //creating order
        Order order = client.orders.create(option);
        System.out.println(order);
        return order.toString();
    }
}
