from django.shortcuts import render
from hospital.models import Hospital
from login.models import Login
from rest_framework.views import APIView,Response
from hospital.serializer import android_serializer
from django.http import HttpResponse


# Create your views here.
def hospital(request):
    if request.method == "POST":
        obj = Hospital()
        obj.h_name = request.POST.get('name')
        obj.address = request.POST.get('adr')
        obj.place= request.POST.get('place')
        obj.phone= request.POST.get('phone')
        obj.email= request.POST.get('email')
        obj.latitude=request.POST.get('LATITUDE')
        obj.longtitude=request.POST.get('LONGTITUDE')
        obj.save()

        ob=Login()
        ob.u_id=obj.h_id
        ob.username=request.POST.get('email')
        ob.password=request.POST.get('pass')
        ob.type='hospital'
        ob.save()

    return render(request,'hospital/hospital.html')



def view_hospital(request):
    oblist=Hospital.objects.all()
    context={
        'objval':oblist,
    }
    return render(request,'hospital/viewhospital.html',context)



class hospital_views(APIView):
    def get(self,request):
        ob=Hospital.objects.all()
        ser=android_serializer(ob,many=True)
        return Response(ser.data)

    def post(self,request):
        obj=Hospital()
        obj.h_name=request.data['h_name']
        obj.address=request.data['address']
        obj.place=request.data['place']
        obj.phone=request.data['phone']
        obj.email=request.data['email']
        obj.save()
        return HttpResponse('ok')