from django.db import models

# Create your models here.

class DangerousLocation(models.Model):
    d_id = models.IntegerField(primary_key=True)
    alert = models.CharField(max_length=20)
    date = models.CharField(max_length=20)
    time = models.CharField(max_length=20)
    location = models.CharField(max_length=20)


    class Meta:
        managed = False
        db_table = 'dangerous_location'



