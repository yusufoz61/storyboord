import { describe, expect, it } from 'vitest'
import { formatDuration } from './shotList.ts'

describe('formatDuration', () => {
  it('formats seconds as m:ss', () => {
    expect(formatDuration(125)).toBe('2:05')
  })
  it('handles zero', () => {
    expect(formatDuration(0)).toBe('0:00')
  })
  it('rejects negative numbers', () => {
    expect(() => formatDuration(-1)).toThrow()
  })
})
