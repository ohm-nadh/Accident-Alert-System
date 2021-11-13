from django.db import models

# Create your models here.
class AccidentAlert(models.Model):
    r_id = models.AutoField(primary_key=True)
    name = models.CharField(max_length=20)
    place = models.CharField(max_length=20)
    accident_alert = models.CharField(max_length=20)
    time = models.CharField(max_length=20)
    date = models.CharField(max_length=20)
    latitude = models.CharField(max_length=100)
    longtitude = models.CharField(max_length=100)

    class Meta:
        managed = False
        db_table = 'accident_alert'



