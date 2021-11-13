from django.contrib.gis.measure import D
from django.shortcuts import render
from django.http import HttpResponse
from dangerous_location.models import DangerousLocation
from rest_framework.views import APIView,Response
from dangerous_location.serializer import android_serializer,Android
from django.http import HttpResponse
from location.models import Location


# Create your views here.
def location(request):
    if request.method=="POST":
        obj=DangerousLocation()
        obj.location=request.POST.get('name')
        obj.alert=request.POST.get('alert')
        obj.date=request.POST.get('DATE')
        obj.time=request.POST.get('time')
        obj.save()

        ob=Location()
        ob.Location = request.POST.get('name')
        ob.latitude = request.POST.get('LATITUDE')
        ob.longtitude = request.POST.get('LONGTITUDE')
        ob.save()

    return render(request,'dangerous_location/dang loc.html')



class dangerous_location_views(APIView):
    def get(self,request):
        ob=DangerousLocation.objects.all()
        ser=android_serializer(ob,many=True)
        return Response(ser.data)

    def post(self,request):
        obj=DangerousLocation()
        obj.alert=request.data['alert']
        obj.date=request.data['date']
        obj.time=request.data['time']
        obj.location=request.data['location']

        obj.save()
        return HttpResponse('ok')

class DD(APIView):
    def get(self, request):
        ob = Location.objects.all()
        ser = Android(ob, many=True)
        return Response(ser.data)

