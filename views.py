from django.shortcuts import render
from django.http import HttpResponse, HttpResponseRedirect
from .models import ToDoList, Item, User
from .forms import CreateNewList, CreateNewUser, UploadFile
from .xml_reader import xml_read


def create(response):
    # we have a post request
    if response.method == "POST":
        form = CreateNewList(response.POST)

        if form.is_valid():
            n = form.cleaned_data["name"]
            t = ToDoList(name=n)
            t.save()

            # return HttpResponseRedirect("main/completesubmission.html")

    # we have a get request
    else:
        form = CreateNewList()
    # inside the () is HTML code
    return render(response, "main/create.html", {"form":form})


def home(response):
    # inside the () is HTML code
    return render(response, "main/home.html", {})


# submission page for .xml file
def submit(response):
    # we have a post request
    if response.method == "POST":

        form = UploadFile(response.POST, response.FILES)
        # debug printing
        print(form.is_valid())

        # check if the form data is valid
        if form.is_valid():
            # assign the form data to variables
            file = response.FILES['file']
            uName = form.cleaned_data['name']
            # debug printing
            print(file.name)
            print(uName)
            # call xml reader to parse data from uploaded file
            parsed_data = xml_read(file)
            # create empty user object
            t = User()
            # set the member variables of the object with form data
            t.setUserData(file)
            t.setUserName(uName)
            t.setParsedData(parsed_data)
            # save the object into the database
            t.save()
            # redriect to complete submission page
            return HttpResponseRedirect("/completesubmission/")

    # we have a get request
    else:

        form = UploadFile()

    # redirect to submission page
    return render(response, "main/submit.html", {"form":form})


def action_page(response):
    return render(response, "main/action_page.html", {})


def completesubmission(response):
    return render(response, "main/completesubmission.html", {})
