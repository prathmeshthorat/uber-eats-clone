# uber-eats-clone
uber eats clone for practice

Order Entity:
userId	FK
addressId	FK
correlationId	
orderTime	
contentsList	
Restaurant	
Status	
isPaid	

Services:
order-service
payment-service
restaurant-service
delivery-service
user-service

User Entity:
userId	
Email	
firstName	
lastName	
mobileNo	
addressList	
joiningDate	
memberType	

OrderItems Entity:
correlationId	FK
restaurantId	FK
menuId	FK
Instructions	
quantity	

Address Entity:
addressId	
firstLane	
secondLane	
City	
State	
Country	
Zipcode	
addressType	
isPrimary	
userId	FK

Order-service:
	getOrderDetails	tested
	getOrderByUserId	tested
	addAddress	tested
	deleteAddress	tested
	createOrder	tested
	getAddressByUserId	tested
	registerUser	tested
	modifyUser	done

Restaurant Entity:

Name	
addressId	FK
Type	Veg, Mix, non-veg
serviceStartTime	
serviceEndTime	
isServing	
waitingPeriod	
restaurantId	

OrderPayment Entity:

correlationId	FK
isPaid	
paymentMethod	
Time	
amount	

Payment-service:
	getPaymentStatus	done
	payForOrder	done
	calculateOrderPrice	NA
	createPaymentRecord	done

Menu Entity:

dishName	
restaurantId	FK
menuId	
dishType	Breakfast, lunch, dinner, snacks
isAvailable	
Price	
discount	

Restaurant-service:
	getRestaurantList	done
	getMenuByRstId	done
	addRestaurant	done
	addMenu	done
	removeMenu	done
	pollOrderEvents	

PasswordManager Entity:

userId	FK
password	

OrderEvents Entity:

correlationId	FK
Status	
userId	FK
addressId	FK
eventId	
owner	

Delivery-service:
	1. updateOrderStatus	
	notifyDeliveryPartner	
	acceptFeedback	
	pollOrderEvents	

