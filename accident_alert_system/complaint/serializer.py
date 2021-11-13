from rest_framework import serializers
from complaint.models import Complaint
from accident_alert.models import AccidentAlert



class android_serializer(serializers.ModelSerializer):
    class Meta:
        model=Complaint
        fields='__all__'



class Android(serializers.ModelSerializer):
    class Meta:
        model=AccidentAlert
        fields='__all__'