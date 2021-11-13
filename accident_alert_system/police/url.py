from django.conf.urls import url
from police import views
urlpatterns = [
    url('^police/',views.police),
]