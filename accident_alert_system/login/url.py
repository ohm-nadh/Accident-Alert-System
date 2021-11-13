from django.conf.urls import url
from login import views
urlpatterns = [
    url('^login/',views.login),
    url('^admin/',views.admin),
    url('^hospital/',views.hospital),
    url('^police/',views.police),
    url('^android/',views.login_view.as_view())
]