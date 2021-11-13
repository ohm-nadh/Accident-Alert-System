from django.conf.urls import url
from accident_alert import views
urlpatterns = [
url('^viewacc/',views.view_accident),
url('^viewpol/',views.view_accidentpol),
url('^viewhosp/',views.view_accidenthosp)

]