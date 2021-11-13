from django.conf.urls import url
from user import views
urlpatterns = [
    url('^android/', views.User_views.as_view()),
    ]