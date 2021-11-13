from django.db import models

# Create your models here.

class Location(models.Model):
    loc_id = models.AutoField(primary_key=True)
    latitude = models.CharField(max_length=20)
    longtitude = models.CharField(max_length=20)
    location = models.CharField(max_length=20)

    class Meta:
        managed = False
        db_table = 'location'

