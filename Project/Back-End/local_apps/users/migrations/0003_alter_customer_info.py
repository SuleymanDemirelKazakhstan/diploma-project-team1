# Generated by Django 4.0.3 on 2022-04-27 13:00

import ckeditor.fields
from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('users', '0002_alter_customer_image'),
    ]

    operations = [
        migrations.AlterField(
            model_name='customer',
            name='info',
            field=ckeditor.fields.RichTextField(blank=True),
        ),
    ]
