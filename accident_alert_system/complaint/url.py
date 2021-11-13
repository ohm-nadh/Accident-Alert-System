from django.conf.urls import url
from complaint import views
urlpatterns = [
    url('^complaint/',views.complaint),
    url('^viewcmp/',views.view_complaint),
    url('^for/',views.forward),
    url('^vwcmpl/',views.vwcmpl),
    url('^android/', views.complaint_views.as_view()),
    url('^android2/', views.Alert.as_view()),
    url('^android3/', views.Alert1.as_view()),
    url('^update_status/(?P<idd>\w+)', views.update_status,name='update_status'),
    url('^postreply/(?P<idd>\w+)', views.post_reply,name='postreply')


]