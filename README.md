<h1>Orders administration system</h1>

The application allows to administrate user's orders via REST-API

<h4>DB structure:</h4>

![img_1.png](img_1.png)

<h4>The necessary functionality in the application:</h4>

<ins>Product:</ins>

* Create product. Generate the random status while creating product (from enum ProductStatus: OUT_OF_STOCK, IN_STOCK, RUNNING_LOW)
* Update product
* Delete product. Product with status IN_STOCK and RUNNING_LOW can't be deleted.
* Get the list of all products sorted by decreasing quantity of orders. Return the product's list with the next fields: name, price, quantity of orders. It is desirable to implement it with SQL-query.

<ins>Order:</ins>
* Create order. Order with the products in status OUT_OF_STOCK and without userId can't be created. Upon the successful creation of the order return its id.
* Get the list of all orders for the time period sorted by userId and the creation date.



