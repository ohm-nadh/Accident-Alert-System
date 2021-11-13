from django.shortcuts import render
from rest_framework.views import APIView,Response
from user.serializer import android_serializer
from django.http import HttpResponse
from user.models import User
from login.models import Login
# Create your views here.
def user(request):
        if request.method == "POST":
            obj = User()
            obj.u_id = request.POST.get('name')
            obj.name = request.POST.get('name')
            obj.place = request.POST.get('PLACE')
            obj.district = request.POST.get('dis')
            obj.address = request.POST.get('adr')
            obj.email = request.POST.get('email')
            obj.phone = request.POST.get('num')
            obj.save()
            return render(request, 'user/REGIS.HTML')

class User_views(APIView):
    def get(self,request):
        ob=User.objects.all()
        ser=android_serializer(ob,many=True)
        return Response(ser.data)

    def post(self,request):
        obj=User()
        obj.name=request.data['name']
        obj.place=request.data['place']
        obj.address=request.data['address']
        obj.phone=request.data['phone']
        obj.email=request.data['username']
        obj.save()

        ob=Login()
        ob.username=request.data['username']
        ob.password=request.data['password']
        ob.u_id=obj.u_id
        ob.type="user"
        ob.save()
        return HttpResponse('ok')