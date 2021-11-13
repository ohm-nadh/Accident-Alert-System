from django.db import models

# Create your models here.


class Violation(models.Model):
    v_id = models.AutoField(primary_key=True)
    violation_type = models.CharField(max_length=20)
    fine = models.CharField(max_length=20)

    class Meta:
        managed = False
        db_table = 'violation'


