# Generated by Django 4.0.3 on 2022-04-28 03:42

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('roadmaps', '0010_alter_specialization_description_and_more'),
    ]

    operations = [
        migrations.AlterField(
            model_name='specialization',
            name='description',
            field=models.TextField(blank=True),
        ),
        migrations.AlterField(
            model_name='technology',
            name='description',
            field=models.TextField(blank=True),
        ),
        migrations.AlterField(
            model_name='topic',
            name='description',
            field=models.TextField(blank=True),
        ),
    ]
