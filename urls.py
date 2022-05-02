from django.urls import path

from . import views
import xml_reader

urlpatterns = [
    path("create/", views.create, name="create"),
    path("", views.home, name="home"),
    path("submit/", views.submit, name = "submit"),
    path("action_page/", views.action_page, name = "action_page"),
    path("completesubmission/", views.completesubmission, name = "completesubmission")
]
