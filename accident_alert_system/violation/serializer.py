from rest_framework import serializers
from violation.models import Violation


class android_serializer(serializers.ModelSerializer):
    class Meta:
        model=Violation
        fields='__all__'