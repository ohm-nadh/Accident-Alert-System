from django.shortcuts import render
from police.models import Police
from login.models import Login
# Create your views here.
def police(request):
        if request.method=="POST":
            obj = Police()
            obj.p_name = request.POST.get('name')
            obj.place = request.POST.get('place')
            obj.district = request.POST.get('dis')
            obj.email = request.POST.get('email')
            obj.phone = request.POST.get('num')
            obj.save()

            ob = Login()
            ob.u_id= obj.p_id
            ob.username = request.POST.get('email')
            ob.password = request.POST.get('pass')
            ob.type = 'Police'
            ob.save()
        return render(request,'police/POLICE.html')
