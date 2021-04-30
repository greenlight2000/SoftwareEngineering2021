package com.group56.model.dao.Impl;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.group56.model.dao.CustomerDAO;
import com.group56.model.entity.Coach;
import com.group56.model.entity.Customer;
import com.group56.model.tools.jsonFileProcessor;

import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {

    public static void main(String[] args) {
        new CoachDAOImpl().insert(new Coach("1","S.C","male","img/Coach.jpg","1","A strong man"));
    }

    public boolean insert(Customer customer) {
        jsonFileProcessor file = new jsonFileProcessor("/Users/wangyunkun/学校/大三下/Software Engineering/Course Work/records/Customer.json");
        StringBuffer buffer = file.read();
        ArrayList<Customer> records = new ArrayList<>();
        if (!buffer.toString().equals("")) {
            records = new Gson().fromJson(buffer.toString(), new TypeToken<ArrayList<Customer>>() {}.getType());
            if (records.size()!=0)
                customer.setCustomerID(String.valueOf(Integer.parseInt(records.get(records.size() - 1).getCustomerID())+1));
        }
        else
            customer.setCustomerID("1");
        records.add(customer);
        return file.rewrite(records);
    }

    public boolean delete(String customerID) {
        jsonFileProcessor file = new jsonFileProcessor("/Users/wangyunkun/学校/大三下/Software Engineering/Course Work/records/Customer.json");
        StringBuffer buffer = file.read();
        if (!buffer.toString().equals("")) {
            ArrayList<Customer> records = new Gson().fromJson(buffer.toString(), new TypeToken<ArrayList<Customer>>(){}.getType());
            for (Customer c : records)
                if (c.getCustomerID().equals(customerID)){
                    records.remove(c);
                    return file.rewrite(records);
                }
        }
        return false;
    }

    public boolean update(Customer customer, String customerID) {
        if (delete(customerID))
            return insert(customer);
        return false;
    }

    public Customer selectByID(String customerID) {
        StringBuffer buffer = new jsonFileProcessor("/Users/wangyunkun/学校/大三下/Software Engineering/Course Work/records/Customer.json").read();
        if (!buffer.toString().equals("")) {
            ArrayList<Customer> records = new Gson().fromJson(buffer.toString(), new TypeToken<ArrayList<Customer>>(){}.getType());
            for (Customer c : records)
                if (c.getCustomerID().equals(customerID))
                    return c;
        }
        return null;
    }
}
