from django.shortcuts import render, get_object_or_404

# Create your views here.

from .models import Meeting

def detail(request, id):
    meeting = get_object_or_404(Meeting, pk=id)
    return render(request, "meetings/detail.html",
                  {"meeting": meeting})
