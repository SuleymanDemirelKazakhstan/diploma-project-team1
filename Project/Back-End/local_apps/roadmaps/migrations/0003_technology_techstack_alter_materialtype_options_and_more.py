# Generated by Django 4.0.3 on 2022-04-18 11:54

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('users', '0001_initial'),
        ('roadmaps', '0002_section_skill'),
    ]

    operations = [
        migrations.CreateModel(
            name='Technology',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(max_length=200)),
                ('description', models.TextField(blank=True)),
                ('slug', models.SlugField(max_length=200)),
                ('skill', models.ManyToManyField(blank=True, to='users.skill')),
            ],
            options={
                'verbose_name': 'Technology',
                'verbose_name_plural': 'Technologies',
                'ordering': ('name',),
            },
        ),
        migrations.CreateModel(
            name='Techstack',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('technology', models.ManyToManyField(related_name='techstacks', to='roadmaps.technology')),
            ],
            options={
                'verbose_name': 'Tech stack',
                'verbose_name_plural': 'Tech stacks',
            },
        ),
        migrations.AlterModelOptions(
            name='materialtype',
            options={'ordering': ('name',), 'verbose_name': 'Material type', 'verbose_name_plural': 'Material types'},
        ),
        migrations.AlterModelOptions(
            name='subtopic',
            options={'ordering': ('name',), 'verbose_name': 'Subtopic', 'verbose_name_plural': 'Subtopics'},
        ),
        migrations.AlterModelOptions(
            name='topic',
            options={'ordering': ('name',), 'verbose_name': 'Topic', 'verbose_name_plural': 'Topics'},
        ),
        migrations.RemoveField(
            model_name='topic',
            name='section',
        ),
        migrations.AddField(
            model_name='specialization',
            name='description',
            field=models.TextField(blank=True),
        ),
        migrations.DeleteModel(
            name='Section',
        ),
        migrations.AddField(
            model_name='technology',
            name='topic',
            field=models.ManyToManyField(related_name='technologies', to='roadmaps.topic'),
        ),
        migrations.AddField(
            model_name='specialization',
            name='techstack',
            field=models.ManyToManyField(related_name='specializations', to='roadmaps.techstack'),
        ),
    ]