from django.shortcuts import render
from login.models import Login
from rest_framework.views import APIView,Response
from login.serializer import android_serializer
from django.http import HttpResponse


def login(request):
    if request.method == "POST":
        username = request.POST.get("user")
        password = request.POST.get("Pass")
        obj = Login.objects.filter(username=username,password=password)
        tp = ""
        for ob in obj:
            tp = ob.type
            uid = ob.u_id
            if tp == "admin":
                request.session["uid"] = uid
                return render(request, 'login/adminhome.html')
            elif tp == "Police":
                request.session["uid"] = uid
                return render(request, 'login/policehome.html')
            elif tp == "hospital":
                request.session["uid"] = uid
                return render(request, 'login/hospitalhome.html')


    return render(request,'login/login.html')

def admin(request):
    return render(request, 'login/adminhome.html')

def hospital(request):
    return render(request,'login/hospitalhome.html')

def police(request):
    return render(request,'login/policehome.html')
class login_view(APIView):
    def get(self, request):
        ob=Login.objects.all()
        ser=android_serializer(ob,many=True)
        return Response(ser.data)

    def post(self,request):
        un=request.data['username']
        ps=request.data['password']
        ob=Login.objects.filter(username=un,password=ps)
        ser=android_serializer(ob,many=True)
        return  Response(ser.data)