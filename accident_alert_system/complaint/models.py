from django.db import models

# Create your models here.

class Complaint(models.Model):
    c_id = models.AutoField(primary_key=True)
    u_id = models.IntegerField()
    complaint = models.CharField(max_length=50)
    date = models.CharField(max_length=20)
    reply = models.CharField(max_length=50)
    image = models.CharField(max_length=500)
    status =  models.CharField(max_length=100)

    class Meta:
        managed = False
        db_table = 'complaint'

