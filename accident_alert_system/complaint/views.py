from django.shortcuts import render
from complaint.models import Complaint
from rest_framework.views import APIView,Response
from complaint.serializer import android_serializer,Android
from django.http import HttpResponse
import datetime
from PIL import Image
from io import BytesIO
import base64
from accident_alert_system import settings


from PIL import Image
from io import BytesIO
import base64
from login.models import Login
from django.views.decorators.csrf import csrf_exempt

import string
from django.http import JsonResponse
from django.db import connection
from django.core.files.storage import FileSystemStorage
from PIL import Image
from io import BytesIO
from django.http import HttpResponseRedirect
import base64



# Create your views here.
def complaint(request):

    return render(request,'complaint/up comp.html')

def view_complaint(request):
    oblist = Complaint.objects.filter(reply="pending")
    context = {
        'objval': oblist,
    }
    return render(request,'complaint/viewcomp.html',context)


def post_reply(request,idd):
    if request.method=="POST":
        ob = Complaint.objects.get(c_id=idd)
        ob.reply=request.POST.get('reply')
        ob.save()
        return HttpResponseRedirect('/complaint/viewcmp/')
    return render(request,'complaint/post_reply.html')


def forward(request):
    oblist = Complaint.objects.all()
    context = {
        'objval': oblist,
    }
    return render(request,'complaint/forward.html',context)

def vwcmpl(request):
    oblist = Complaint.objects.filter(status='pending').exclude(reply='pending')
    context = {
        'objval': oblist,
    }
    return render(request,'complaint/vwcmpl.html',context)

def update_status(request,idd):
    if request.method=='POST':
        ob=Complaint.objects.get(c_id=idd)
        ob.status=request.POST.get('status')
        ob.save()
        return HttpResponseRedirect('/complaint/vwcmpl/')
    return render(request,'complaint/update_statud.html')

class complaint_views(APIView):
    def get(self,request):
        ob=Complaint.objects.all()
        ser=android_serializer(ob,many=True)
        return Response(ser.data)

    def post(self,request):
        obj=Complaint()
        obj.u_id=request.data['u_id']
        obj.complaint=request.data['complaint']
        obj.date=datetime.datetime.today()
        obj.reply="pending"
        # obj.reply=request.data['reply']
        obj.image=""
        obj.status="pending"
        obj.save()

        idd = str(obj.c_id)
        i = idd + ".jpg"

        f = request.data['image']

        im = Image.open(BytesIO(base64.b64decode(f)))
        imgpath = settings.BASE_DIR + settings.STATIC_URL + i
        im.save(imgpath)

        obj=Complaint.objects.get(c_id=idd)
        obj.image=i
        obj.save()
        return HttpResponse('ok')

from accident_alert.models import AccidentAlert
from user.models import User

class Alert(APIView):
    def get(self,request):
        ob = AccidentAlert.objects.all()
        ser=Android(ob,many=True)
        return Response(ser.data)
    def post(self,request):
        uid = request.data['uid']
        print(uid)

        uu = User.objects.get(u_id=uid)

        obj = AccidentAlert()
        obj.latitude = request.data['lat']
        obj.longtitude = request.data['lon']
        obj.date = datetime.date.today()
        obj.time = datetime.datetime.now().time()
        obj.name = uu.name
        obj.accident_alert = 'Accident Alert'
        obj.place = 'calicut'
        obj.save()
        return HttpResponse('ok')

class Alert1(APIView):

    def post(self,request):
        uid = request.data['rid']
        obj = AccidentAlert.objects.get(r_id=uid)
        obj.delete()

        return HttpResponse('ok')