

class Logger(object):

    def __init__(self):
        self.ok = {}

    def shouldPrintMessage(self, timestamp, message):
        print "timestamp = ", timestamp
	print "message = ", message
        
	if timestamp < self.ok.get(message, 0):
	    print "self.ok = ", self.ok
	    print "False"
            return False
        self.ok[message] = timestamp + 10
	print "self.ok = ", self.ok

	print "True"
        return True
        


# Your Logger object will be instantiated and called as such:
obj = Logger()
param_1 = obj.shouldPrintMessage(1,"foo")
param_1 = obj.shouldPrintMessage(2,"bar")
param_1 = obj.shouldPrintMessage(3,"foo")
param_1 = obj.shouldPrintMessage(8,"bar")
param_1 = obj.shouldPrintMessage(10,"foo")
param_1 = obj.shouldPrintMessage(11,"foo")
