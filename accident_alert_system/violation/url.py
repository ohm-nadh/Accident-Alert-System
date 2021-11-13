from django.conf.urls import url
from violation import views
urlpatterns = [
    url('^violation/',views.violation),
url('^vievltn/',views.view_violation),
    url('^android/', views.violation_views.as_view())
]