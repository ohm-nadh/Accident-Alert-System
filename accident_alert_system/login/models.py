from django.db import models

# Create your models here.

class Login(models.Model):
    log_id = models.AutoField(primary_key=True)
    u_id = models.IntegerField()
    username = models.CharField(max_length=50)
    password = models.CharField(max_length=20)
    type = models.CharField(max_length=20)

    class Meta:
        managed = False
        db_table = 'login'

