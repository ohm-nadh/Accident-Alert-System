from django.db import models

# Create your models here.
class Police(models.Model):
    p_id = models.AutoField(primary_key=True)
    p_name = models.CharField(max_length=20)
    place = models.CharField(max_length=20)
    district = models.CharField(max_length=100)
    email = models.CharField(max_length=20)
    phone = models.CharField(max_length=20)

    class Meta:
        managed = False
        db_table = 'police'


