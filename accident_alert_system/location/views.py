from django.shortcuts import render
from location.models import Location
from rest_framework.views import APIView,Response
from location.serializer import android_serializer
from django.http import HttpResponse


# Create your views here.
def location(request):
    if request.method == "POST":
        obj = location()
        obj.loc_id = request.POST.get('name')
        obj.latitude = request.POST.get('adr')
        obj.longitude= request.POST.get('PLACE')
        obj.location= request.POST.get('time')
        obj.save()
    return render(request,'location/loc.html')

class location_views(APIView):
    def get(self,request):
        ob=Location.objects.all()
        ser=android_serializer(ob,many=True)
        return Response(ser.data)

    def post(self,request):
        obj=Location()
        obj.latitude=request.data['latitude']
        obj.longtitude=request.data['longtitude']
        obj.location=request.data['location']

        obj.save()
        return HttpResponse('ok')