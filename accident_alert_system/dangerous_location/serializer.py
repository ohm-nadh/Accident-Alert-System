from rest_framework import serializers
from dangerous_location.models import DangerousLocation
from location.models import Location


class android_serializer(serializers.ModelSerializer):
    class Meta:
        model=DangerousLocation
        fields='__all__'


class Android(serializers.ModelSerializer):
    class Meta:
        model=Location
        fields='__all__'