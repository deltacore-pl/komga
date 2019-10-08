package org.gotson.komga.domain.persistence

import org.gotson.komga.domain.model.Series
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.net.URL

@Repository
interface SeriesRepository : JpaRepository<Series, Long>, JpaSpecificationExecutor<Series> {
  fun findByLibraryIdAndUrlNotIn(libraryId: Long, urls: Iterable<URL>): List<Series>
  fun findByLibraryIdAndUrl(libraryId: Long, url: URL): Series?
  fun deleteByLibraryId(libraryId: Long)
}