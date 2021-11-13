from django.shortcuts import render
from violation.models import Violation
from rest_framework.views import APIView,Response
from violation.serializer import android_serializer
from django.http import HttpResponse


# Create your views here.
def violation(request):
    if request.method == "POST":
        obj = Violation()
        obj.violation_type = request.POST.get('violation')
        obj.fine = request.POST.get('fine')
        obj.save()
    return render(request,'violation/TRAFFIC.html')

def view_violation(request):
    oblist = Violation.objects.all()
    context = {
        'objval': oblist,
    }
    return render(request,'violation/viewvioltn.html',context)

class violation_views(APIView):
    def get(self,request):
        ob=Violation.objects.all()
        ser=android_serializer(ob,many=True)
        return Response(ser.data)

    def post(self,request):
        obj=Violation()
        obj.violation_type=request.data['violation_type']
        obj.fine=request.data['fine']

        obj.save()
        return HttpResponse('ok')
