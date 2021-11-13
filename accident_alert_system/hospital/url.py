from django.conf.urls import url
from hospital import views
urlpatterns = [
    url('^hospital/',views.hospital),
    url('^viewhos/',views.view_hospital),
    url('^android/',views.hospital_views.as_view())


]
