from django.db import models

# Create your models here.

class User(models.Model):
    u_id = models.AutoField(primary_key=True)
    name = models.CharField(max_length=20)
    place = models.CharField(max_length=20)
    address = models.CharField(max_length=50)
    email = models.CharField(max_length=20)
    phone = models.CharField(max_length=20)

    class Meta:
        managed = False
        db_table = 'user'

