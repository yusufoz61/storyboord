export function formatDuration(totalSeconds: number): string {
  if (totalSeconds < 0) throw new Error('Duration cannot be negative')
  const minutes = Math.floor(totalSeconds / 60)
  const seconds = totalSeconds % 60
  return `${minutes}:${seconds.toString().padStart(2, '0')}`
}
