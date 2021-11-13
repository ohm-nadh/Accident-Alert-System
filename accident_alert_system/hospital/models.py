from django.db import models

# Create your models here.
class Hospital(models.Model):
    h_id = models.AutoField(primary_key=True)
    h_name = models.CharField(max_length=50)
    address = models.CharField(max_length=50)
    place = models.CharField(max_length=50)
    phone = models.CharField(max_length=20)
    email = models.CharField(max_length=50)
    latitude = models.CharField(max_length=50)
    longtitude = models.CharField(max_length=50)

    class Meta:
        managed = False
        db_table = 'hospital'

