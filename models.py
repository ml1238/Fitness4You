from django.db import models

# Create your models here.


# example class
class ToDoList(models.Model):
    name = models.CharField(max_length=200)

    def __str__(self):
        return self.name


# example class
class Item(models.Model):
    todolist = models.ForeignKey(ToDoList, on_delete=models.CASCADE)
    text = models.CharField(max_length=300)
    complete = models.BooleanField()

    def __str__(self):
        return self.text


# object user to hold the userName and its data dictionary
class User(models.Model):

    uName = models.CharField(max_length=300, default='no name')
    userData = models.FileField(default='export.xml')
    parsedData = models.CharField(max_length=1000, default='empty')

    def setUserName(self,n):
        self.uName=n

    def setUserData(self,d):
        self.userData=d

    def setParsedData(self, p):
        self.parsedData=p

    # to string method
    def __str__(self):
        return self.uName
