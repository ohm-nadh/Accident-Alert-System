from django.shortcuts import render
from django.http import HttpResponse
from accident_alert.models import AccidentAlert


# Create your views here.



def view_accident(request):
    oblist = AccidentAlert.objects.all()
    context = {
        'objval': oblist,
    }
    return render(request,'accident_alert/viewaccdntalrt.html',context)


def view_accidentpol(request):
    oblist = AccidentAlert.objects.all()
    context = {
        'objval': oblist,
    }
    return render(request,'accident_alert/viewaccalpolice.html',context)

def view_accidenthosp(request):
    oblist = AccidentAlert.objects.all()
    context = {
        'objval': oblist,
    }
    return render(request,'accident_alert/viewacchosp.html',context)


