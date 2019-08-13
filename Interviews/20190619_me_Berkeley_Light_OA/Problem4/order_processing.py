import unittest
import pdb

# The class Person is used to represent a user.
class Person:
    def __init__(self, name, card_number):
        self.name = name
        self.card_number = card_number

# THe class Order is used to represent a order.
class Order:
    def  __init__(self, card_number, product_name, price):
        self.card_number = card_number
        self.product_name = product_name
        self.price = price

# The class store represents the persistent store. sending email function is implemented here
class Store:
    def __init__(self):
        self.product = dict()

    def addProduct(self, product_name, quantity):
        self.product[product_name] = quantity

    def checkProduct(self, product_name):
        if product_name in self.product.keys():
            if self.product[product_name] > 0: return True
            else: return False
        return False

    def sendEmail(self):
        print("your order is placed")

    def placeOrder(self, product_name):
        self.product[product_name] -= 1
        self.sendEmail()

def ChargePayment(creditCardNumber, amount):
    return True

# All unit test cases
class TestMethods(unittest.TestCase):
    def setUp(self):
        self.p = Person("Zoe", 1234)
        self.s = Store()
        self.s.addProduct("basketball",1000)
        self.s.addProduct("handball",10)
        self.s.addProduct("baseball",1)
        self.o = Order(self.p.card_number, "basktball", 20)
        if self.s.checkProduct(self.o.product_name) and ChargePayment(self.o.card_number, self.o.price):
            #pdb.set_trace()
            self.s.placeOrder(self.o.product_name)

    def testCheckProduct(self):
        self.assertEqual(self.s.product["basketball"], 1000)
        self.assertEqual(self.s.product["handball"], 10)
        self.assertEqual(self.s.product["baseball"], 1)
        

if __name__ == "__main__":
    p = Person("Zoe", 1234)
    s = Store()
    s.addProduct("basketball",1000)
    s.addProduct("handball",10)
    s.addProduct("baseball",1)
    o = Order(p.card_number, "shakeball", 20)
    
    if s.checkProduct(o.product_name) and ChargePayment(o.card_number, o.price):
        # need to test prodoct number is decreased
        s.placeOrder(o.product_name)
    else:
        print("your order can't be placed")
    # Call the unittest
    unittest.main()
