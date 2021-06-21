package org.oppia.android.app.devoptions.markstoriescompleted

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.oppia.android.app.fragment.InjectableFragment
import javax.inject.Inject

/** Fragment to display all stories and provide functionality to mark them completed. */
class MarkStoriesCompletedFragment : InjectableFragment() {
  companion object {
    internal const val MARK_STORIES_COMPLETED_FRAGMENT_PROFILE_ID_KEY =
      "MarkStoriesCompletedFragment.internal_profile_id"

    /** Returns a new [MarkStoriesCompletedFragment]. */
    fun newInstance(internalProfileId: Int): MarkStoriesCompletedFragment {
      val markStoriesCompletedFragment = MarkStoriesCompletedFragment()
      val args = Bundle()
      args.putInt(MARK_STORIES_COMPLETED_FRAGMENT_PROFILE_ID_KEY, internalProfileId)
      markStoriesCompletedFragment.arguments = args
      return markStoriesCompletedFragment
    }
  }

  @Inject
  lateinit var markStoriesCompletedFragmentPresenter: MarkStoriesCompletedFragmentPresenter

  override fun onAttach(context: Context) {
    super.onAttach(context)
    fragmentComponent.inject(this)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val args =
      checkNotNull(arguments) { "Expected arguments to be passed to MarkStoriesCompletedFragment" }
    val internalProfileId = args
      .getInt(MARK_STORIES_COMPLETED_FRAGMENT_PROFILE_ID_KEY, -1)
    return markStoriesCompletedFragmentPresenter.handleCreateView(
      inflater,
      container,
      internalProfileId
    )
  }
}
