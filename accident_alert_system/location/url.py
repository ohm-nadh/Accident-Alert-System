from django.conf.urls import url
from location import views
urlpatterns = [

    url('^android/', views.location_views.as_view())
]