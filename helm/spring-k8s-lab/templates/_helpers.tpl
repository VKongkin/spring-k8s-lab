{{- define "spring-k8s-lab.name" -}}
{{- .Chart.Name -}}
{{- end -}}

{{- define "spring-k8s-lab.labels" -}}
app.kubernetes.io/name: {{ include "spring-k8s-lab.name" . }}
app.kubernetes.io/instance: {{ .Release.Name }}
app.kubernetes.io/version: {{ .Chart.AppVersion | quote }}
app.kubernetes.io/managed-by: {{ .Release.Service }}
{{- end -}}

{{- define "spring-k8s-lab.selectorLabels" -}}
app.kubernetes.io/name: {{ include "spring-k8s-lab.name" . }}
app.kubernetes.io/instance: {{ .Release.Name }}
{{- end -}}

{{- define "spring-k8s-lab.fullname" -}}
{{- printf "%s-%s" .Release.Name .Chart.Name | trunc 63 | trimSuffix "-" -}}
{{- end -}}