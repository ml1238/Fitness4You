from django import forms
from django.core.files.uploadedfile import SimpleUploadedFile
from .models import User
import xml_reader


# class CreateNewList(forms.Form):
    # name = forms.CharField(max_length=200)
    # check = forms.BooleanField(required=False)


class CreateNewUser(forms.Form):
    file = forms.FileField()
    uName = forms.CharField(max_length=40)


class UploadFile(forms.Form):
    name = forms.CharField(max_length=40)
    file = forms.FileField()
