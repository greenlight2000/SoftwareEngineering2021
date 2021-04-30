package com.group56.model.dao;


import com.group56.model.entity.Customer;

/**
 * @Description: The data access object layer interface of the file Customer.json
 *               is used to provide a method for adding, deleting, and modifying
 *               the file.
 * @author Yang Junhan
 * @version V1.0
 * @date 2021/4/5
 */

public interface CustomerDAO {
    /**
     * @Description: Insert a new customer record into file.
     * @param customer: The coach will be inserted into file.
     * @return boolean: If the operation executed successful, return true.
     *                  if the operation fails, return false.
     */
    public boolean insert(Customer customer);

    /**
     * @Description: Delete a customer.
     * @param customerID: The customerID of the customer will be delete.
     * @return boolean: If the operation executed successful, return true.
     *                  if the operation fails, return false.
     */
    public boolean delete(String customerID);

    /**
     * @Description: Update a new customer record into file.
     * @param customer: The new content of the customer .
     * @param customerID: The id of customer will be updated.
     * @return boolean: If the operation executed successful, return true.
     *                  if the operation fails, return false.
     */
    public boolean update(Customer customer, String customerID);

    /**
     * @Description: Select a customer.
     * @param customerID: The customerID of customer will be selected.
     * @return The customer selected by ID.
     */
    public Customer selectByID(String customerID);

}
