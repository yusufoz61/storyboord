# ---- build stage ----
FROM node:24 AS build
WORKDIR /app
COPY ../storyboord-apply/frontend/package.json package-lock.json ./
RUN npm ci
COPY ../storyboord-apply/frontend .
RUN npm run build-only

# ---- run stage ----
FROM nginx:alpine
COPY --from=build /app/dist /usr/share/nginx/html
EXPOSE 80
