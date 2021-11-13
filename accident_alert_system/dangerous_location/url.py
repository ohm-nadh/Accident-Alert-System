from django.conf.urls import url
from dangerous_location import views
urlpatterns = [
    url('^location/',views.location),
    url('^android/', views.dangerous_location_views.as_view()),
    url('^android2/', views.DD.as_view())
]