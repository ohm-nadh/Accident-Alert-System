from rest_framework import serializers
from accident_alert.models import AccidentAlert


class android_serializer(serializers.ModelSerializer):
    class Meta:
        model=AccidentAlert
        fields='__all__'